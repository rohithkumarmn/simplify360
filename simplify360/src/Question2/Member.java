package Question2;

import java.util.ArrayList;
import java.util.List;

public class Member {
	
	 private String name;
     private List<Member> connections;

     public Member(String name) {
         this.name = name;
         connections = new ArrayList<>();
     }

     public String getName() {
         return name;
     }

     public List<Member> getConnections() {
         return connections;
     }

     public void connect(Member friend) {
         connections.add(friend);
     }
	
	

}
