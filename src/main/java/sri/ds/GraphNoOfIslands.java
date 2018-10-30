package sri.ds;

public class GraphNoOfIslands {
    //FIXME returning improper value
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
        if(i < 0 || j < 0 ||
            i == graph.length || j == graph[i].length) {
            return;
        }
        visited[i][j] = true;
        if(graph[i][j] == 0)
            return;
        dfs(graph,visited,i,j+1);
        dfs(graph,visited,i+1,j);
        dfs(graph,visited,i+1,j+1);
        dfs(graph,visited,i-1,j+1);
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,1,0,0,0},
                        {0,1,0,0,1},
                        {1,0,0,1,1},
                        {0,0,0,0,0},
                        {1,0,1,0,1}
                };
        System.out.println(new GraphNoOfIslands().count(matrix));
    }
}
