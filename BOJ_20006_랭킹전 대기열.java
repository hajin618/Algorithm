import java.io.*;
import java.util.*;

public class Main {

    static int p, m;
    static Player[] players;
    static List<Player> list;

    static class Player implements Comparable<Player>{
        int level;
        String name;
        boolean flag;

        Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o){
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        players = new Player[p];

        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String m = st.nextToken();

            players[i] = new Player(l, m);
        }

        for(int i=0; i<p; i++){
            if(players[i].flag)
                continue;

            list = new ArrayList<>();

            for(int j=i; j<p; j++){
                if(list.size() == m)
                    break;

                int l = players[j].level;
                String n = players[j].name;

                if(!players[j].flag && players[i].level - 10 <= l && players[i].level + 10 >= l){
                    list.add(new Player(l, n));
                    players[j].flag = true;
                }
            }

            Collections.sort(list);

            if(list.size() == m){
                sb.append("Started!").append("\n");
            }
            else{
                sb.append("Waiting!").append("\n");
            }

            for(Player p : list){
                sb.append(p.level).append(" ").append(p.name).append("\n");
            }
        }

        System.out.println(sb);
    }
}