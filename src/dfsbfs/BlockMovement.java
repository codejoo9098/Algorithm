package dfsbfs;
import java.util.*;

class Robot {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    
    int x, y, direction;
    int count = -1;
    
    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    public Robot(int x, int y, int direction, int count) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.count = count;
    }
    
    public boolean equals(Object obj) {
        Robot robot = (Robot)obj;
        
        int reverse = direction;
        if (reverse == 1) reverse = 3;
        else if (reverse == 0) reverse = 2;
        else reverse -= 2;
        
        if (x == robot.x && y == robot.y && direction == robot.direction) return true;
        if (x + dx[direction] == robot.x && y + dy[direction] == robot.y && reverse == robot.direction) return true;
        
        return false;
    }
    
    public void turnLeft(boolean isChangingPos) {
        if (isChangingPos) {
            x += dx[direction];
            y += dy[direction];
        }
        
        if (direction == 3) direction = 0;
        else direction++;
    }
    
    public void turnRight(boolean isChangingPos) {
        if (isChangingPos) {
            x += dx[direction];
            y += dy[direction];
        }
        
        if (direction == 0) direction = 3;
        else direction--;
    }
}

class BlockMovement {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    static int[][] boardMap;
    static int n, answer;
    static Deque<Robot> deque = new ArrayDeque<>();
    static Deque<Robot> visitedList = new ArrayDeque<>();
    
    public static void main(String[] args) {
    	int[][] board = {{0, 0, 0, 1, 1},
    					{0, 0, 0, 1, 0},
    					{0, 1, 0, 1, 1},
    					{1, 1, 0, 0, 1},
    					{0, 0, 0, 0, 0}};
    	
    	System.out.println(solution(board));
    }
    
    public static int solution(int[][] board) {
        answer = 1000000;
        boardMap = board;
        n = board.length;
        
        deque.addFirst(new Robot(0, 0, 0, 0));
        visitedList.addFirst(new Robot(0, 0, 0, 0));
        
        bfs();
        return answer;
    }
    
    public static void bfs() {
        while(!deque.isEmpty()) {
            Robot robot = deque.removeLast();
            
            if (isAnswerFound(robot)) {
                answer = Math.min(answer, robot.count);
            }
            
            Robot[] robotList = new Robot[4];
            for (int i = 0; i < 4; i++) {
                robotList[i] = new Robot(robot.x, robot.y, robot.direction);
            }
            
            robotList[0].turnLeft(false);
            robotList[1].turnLeft(true);
            if (isTurningPossible(robotList[0]) && isTurningPossible(robotList[1])) {
                putTurnedRobot(robotList[0], robot.count);
                putTurnedRobot(robotList[1], robot.count);
            }
            
            robotList[2].turnRight(false);
            robotList[3].turnRight(true);
            if (isTurningPossible(robotList[2]) && isTurningPossible(robotList[3])) { 
                putTurnedRobot(robotList[2], robot.count);
                putTurnedRobot(robotList[3], robot.count);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = robot.x + dx[i];
                int ny = robot.y + dy[i];
                Robot nRobot = new Robot(nx, ny, robot.direction);
                
                if (isMovingPossible(nRobot)) {
                    nRobot.count = robot.count + 1;
                    
                    visitedList.addFirst(nRobot);
                    deque.addFirst(nRobot);
                }
            }
        }
    }
    
    public static boolean isMovingPossible(Robot robot) {
        int x1 = robot.x;
        int y1 = robot.y;
        int x2 = robot.x + dx[robot.direction];
        int y2 = robot.y + dy[robot.direction];
        
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return false;
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) return false;
        if (boardMap[x1][y1] == 1 || boardMap[x2][y2] == 1) return false;
        if (visitedList.contains(robot)) return false;
        
        return true;
    }
    
    public static boolean isTurningPossible(Robot robot) {
        int x1 = robot.x;
        int y1 = robot.y;
        int x2 = robot.x + dx[robot.direction];
        int y2 = robot.y + dy[robot.direction];
        
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) return false;
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n) return false;
        if (boardMap[x1][y1] == 1 || boardMap[x2][y2] == 1) return false;
        
        return true;
    }
    
    public static void putTurnedRobot(Robot robot, int prevCount) {
        if (!visitedList.contains(robot)) {
            robot.count = prevCount + 1;
            
            visitedList.addFirst(robot);
            deque.addFirst(robot);
        }
    }
    
    public static boolean isAnswerFound(Robot robot) {
        if (robot.x == n - 1 && robot.y == n - 1) return true;
        
        if (robot.x + dx[robot.direction] < 0 || robot.y + dy[robot.direction] < 0) return false;
        if (robot.x + dx[robot.direction] >= n || robot.y + dy[robot.direction] >= n) return false;
        if (robot.x + dx[robot.direction] == n - 1 && robot.y + dy[robot.direction] == n - 1) return true;
        
        return false;
    }
}