package GlobusSoft;

import java.util.Arrays;

public class HungarianAlgorithm {
    private int[][] costMatrix;
    private int[] labelsByWorker, labelsByJob;
    private int[] minSlackWorkerByJob;
    private int[] minSlackValueByJob;
    private int[] matchJobByWorker, matchWorkerByJob;
    private int[] parentWorkerByCommittedJob;
    private boolean[] committedWorkers;

    public HungarianAlgorithm(int[][] costMatrix) {
        int n = costMatrix.length;
        int m = costMatrix[0].length;
        this.costMatrix = new int[n][m];
        for (int worker = 0; worker < n; worker++) {
            if (costMatrix[worker].length != m) {
                throw new IllegalArgumentException("Irregular cost matrix");
            }
            this.costMatrix[worker] = Arrays.copyOf(costMatrix[worker], m);
        }
        labelsByWorker = new int[n];
        labelsByJob = new int[m];
        minSlackWorkerByJob = new int[m];
        minSlackValueByJob = new int[m];
        committedWorkers = new boolean[n];
        parentWorkerByCommittedJob = new int[m];
        matchJobByWorker = new int[n];
        Arrays.fill(matchJobByWorker, -1);
        matchWorkerByJob = new int[m];
        Arrays.fill(matchWorkerByJob, -1);
    }

    protected void computeInitialFeasibleSolution() {
        for (int j = 0; j < labelsByJob.length; j++) {
            labelsByJob[j] = Integer.MAX_VALUE;
        }
        for (int worker = 0; worker < costMatrix.length; worker++) {
            for (int job = 0; job < costMatrix[worker].length; job++) {
                if (costMatrix[worker][job] < labelsByJob[job]) {
                    labelsByJob[job] = costMatrix[worker][job];
                }
            }
        }
    }

    public int[] execute() {
        reduce();
        computeInitialFeasibleSolution();
        greedyMatch();
        int w;
        while ((w = fetchUnmatched()) < costMatrix.length) {
            initializePhase(w);
            executePhase();
        }
        int[] result = Arrays.copyOf(matchJobByWorker, costMatrix.length);
        for (w = 0; w < result.length; w++) {
            if (result[w] >= costMatrix[0].length) {
                result[w] = -1;
            }
        }
        return result;
    }

    protected void executePhase() {
        while (true) {
            int minSlackWorker = -1, minSlackJob = -1;
            int minSlackValue = Integer.MAX_VALUE;
            for (int j = 0; j < minSlackValueByJob.length; j++) {
                if (parentWorkerByCommittedJob[j] == -1) {
                    if (minSlackValueByJob[j] < minSlackValue) {
                        minSlackValue = minSlackValueByJob[j];
                        minSlackWorker = minSlackWorkerByJob[j];
                        minSlackJob = j;
                    }
                }
            }
            if (minSlackValue > 0) {
                updateLabeling(minSlackValue);
            }
            parentWorkerByCommittedJob[minSlackJob] = minSlackWorker;
            if (matchWorkerByJob[minSlackJob] == -1) {
                int committedJob = minSlackJob;
                int parentWorker = parentWorkerByCommittedJob[committedJob];
                while (true) {
                    int temp = matchJobByWorker[parentWorker];
                    match(parentWorker, committedJob);
                    committedJob = temp;
                    if (committedJob == -1) {
                        break;
                    }
                    parentWorker = parentWorkerByCommittedJob[committedJob];
                }
                return;
            } else {
                int worker = matchWorkerByJob[minSlackJob];
                committedWorkers[worker] = true;
                for (int j = 0; j < minSlackValueByJob.length; j++) {
                    if (parentWorkerByCommittedJob[j] == -1) {
                        int slack = costMatrix[worker][j] - labelsByWorker[worker] - labelsByJob[j];
                        if (minSlackValueByJob[j] > slack) {
                            minSlackValueByJob[j] = slack;
                            minSlackWorkerByJob[j] = worker;
                        }
                    }
                }
            }
        }
    }

    protected int fetchUnmatched() {
        int w;
        for (w = 0; w < costMatrix.length; w++) {
            if (matchJobByWorker[w] == -1) {
                break;
            }
        }
        return w;
    }

    protected void greedyMatch() {
        for (int w = 0; w < costMatrix.length; w++) {
            for (int j = 0; j < costMatrix[w].length; j++) {
                if (matchJobByWorker[w] == -1
                        && matchWorkerByJob[j] == -1
                        && costMatrix[w][j] - labelsByWorker[w] - labelsByJob[j] == 0) {
                    match(w, j);
                }
            }
        }
    }

    protected void initializePhase(int w) {
        Arrays.fill(committedWorkers, false);
        Arrays.fill(parentWorkerByCommittedJob, -1);
        committedWorkers[w] = true;
        for (int j = 0; j < minSlackValueByJob.length; j++) {
            minSlackValueByJob[j] = costMatrix[w][j] - labelsByWorker[w] - labelsByJob[j];
            minSlackWorkerByJob[j] = w;
        }
    }

    protected void match(int w, int j) {
        matchJobByWorker[w] = j;
        matchWorkerByJob[j] = w;
    }

    protected void reduce() {
        for (int w = 0; w < costMatrix.length; w++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < costMatrix[w].length; j++) {
                if (costMatrix[w][j] < min) {
                    min = costMatrix[w][j];
                }
            }
            for (int j = 0; j < costMatrix[w].length; j++) {
                costMatrix[w][j] -= min;
            }
        }
        double[] min = new double[costMatrix[0].length];
        for (int j = 0; j < min.length; j++) {
            min[j] = Integer.MAX_VALUE;
        }
        for (int w = 0; w < costMatrix.length; w++) {
            for (int j = 0; j < costMatrix[w].length; j++) {
                if (costMatrix[w][j] < min[j]) {
                    min[j] = costMatrix[w][j];
                }
            }
        }
        for (int w = 0; w < costMatrix.length; w++) {
            for (int j = 0; j < costMatrix[w].length; j++) {
                costMatrix[w][j] -= min[j];
            }
        }
    }

    protected void updateLabeling(int slack) {
        for (int w = 0; w < labelsByWorker.length; w++) {
            if (committedWorkers[w]) {
                labelsByWorker[w] += slack;
            }
        }
        for (int j = 0; j < labelsByJob.length; j++) {
            if (parentWorkerByCommittedJob[j] != -1) {
                labelsByJob[j] -= slack;
            } else {
                minSlackValueByJob[j] -= slack;
            }
        }
    }
}
