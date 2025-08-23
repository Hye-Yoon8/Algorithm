import java.io.*;
import java.util.*;

public class BOJ_20006 {
    static class Player {
        int level;
        String name;
        Player(int l, String n) {
        	level=l;
        	name=n;
    	}
    }
    
    static class Room {
        int base;
        int cap;
        List<Player> ps = new ArrayList<>();
        
        Room(int base, int cap, Player first) {
        	this.base = base;
        	this.cap = cap;
        	ps.add(first);
    	}
        
        boolean canJoin(int lv) { return ps.size() < cap && Math.abs(lv-base) <= 10; }
        void add(Player p){ ps.add(p); }
        boolean isFull(){ return ps.size() == cap; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for(int i=0;i<P;i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player cur = new Player(level, name);

            boolean placed = false;
            for(Room r : rooms) {
            	if(r.canJoin(level)){
            		r.add(cur);
            		placed = true;
            		break;
        		}
            }
            
            if(!placed) rooms.add(new Room(level, M, cur));
        }

        StringBuilder sb = new StringBuilder();
        for(Room r : rooms){
            sb.append(r.isFull() ? "Started!\n" : "Waiting!\n");
            r.ps.sort(Comparator.comparing(p -> p.name));
            for(Player p : r.ps) sb.append(p.level).append(' ').append(p.name).append('\n');
        }
        System.out.print(sb);
    }
}
