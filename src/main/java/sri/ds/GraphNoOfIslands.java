package sri.ds;

/**
 * Count number of islands in a graph.
 * https://www.geeksforgeeks.org/find-number-of-islands/
 */
public class GraphNoOfIslands {
    public int count(int[][] graph) {
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        for(int i=0;i<graph.length;i++) {
            for (int j=0;j < graph[i].length;j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    dfs(graph,visited,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] graph, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        if(graph[i][j] == 0)
            return;
        int[] rowOffsetArray = {-1,-1,-1,0,0,1,1,1};
        int[] columnOffsetArray = {-1,0,1,-1,1,-1,0,1};

        for(int k = 0; k < rowOffsetArray.length; k++) {
            int rowOffset = i+rowOffsetArray[k];
            int colOffset = j+columnOffsetArray[k];
            boolean canVisit = (rowOffset > -1) && (rowOffset < graph.length) &&
                    (colOffset > -1) && (colOffset < graph[rowOffset].length) && !visited[rowOffset][colOffset];
            if(canVisit)
                dfs(graph,visited,rowOffset,colOffset);
        }
    }

    public static void main(String[] args) {
        // has 5 islands.
        int[][] matrix =
                {
                        {1,1,0,0,0},
                        {0,1,0,0,1},
                        {1,0,0,1,1},
                        {0,0,0,0,0},
                        {1,0,1,0,1}
                };

        //has 1 island.
        int[][] matrix2 =
                {
                        {1,1,0,0,0},
                        {0,1,0,0,1},
                        {0,0,1,1,1},
                        {0,0,1,0,0},
                        {0,0,1,0,0}
                };

        System.out.println(new GraphNoOfIslands().count(matrix));
        System.out.println(new GraphNoOfIslands().count(matrix2));
    }

}
