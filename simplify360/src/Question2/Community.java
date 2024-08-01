package Question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Community {

    private Map<String, Member> network;

    public Community() {
        network = new HashMap<>();
    }

    public void addMember(String name) {
        network.putIfAbsent(name, new Member(name));
    }

    public void createConnection(String name1, String name2) {
        Member member1 = network.get(name1);
        Member member2 = network.get(name2);

        if (member1 != null && member2 != null) {
            member1.connect(member2);
            member2.connect(member1);
        }
    }

    public List<String> listConnections(String name) {
        Member member = network.get(name);
        List<String> connections = new ArrayList<>();
        if (member != null) {
            for (Member friend : member.getConnections()) {
                connections.add(friend.getName());
            }
        }
        return connections;
    }

    public List<String> listMutualConnections(String name1, String name2) {
        Set<String> mutualConnections = new HashSet<>(listConnections(name1));
        mutualConnections.retainAll(listConnections(name2));
        return new ArrayList<>(mutualConnections);
    }

    public int findConnectionLevel(String name1, String name2) {
        if (!network.containsKey(name1) || !network.containsKey(name2)) {
            return -1;
        }

        Queue<Member> queue = new LinkedList<>();
        Map<Member, Integer> levels = new HashMap<>();
        Member start = network.get(name1);
        Member target = network.get(name2);

        queue.add(start);
        levels.put(start, 0);

        while (!queue.isEmpty()) {
            Member current = queue.poll();
            int currentLevel = levels.get(current);

            for (Member connection : current.getConnections()) {
                if (!levels.containsKey(connection)) {
                    levels.put(connection, currentLevel + 1);
                    queue.add(connection);
                    if (connection.equals(target)) {
                        return levels.get(connection);
                    }
                }
            }
        }

        return -1;
    }
    
    
}