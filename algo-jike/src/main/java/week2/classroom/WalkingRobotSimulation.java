package week2.classroom;

import java.util.HashSet;

/**
 * @Describe : leetcode:874 【模拟行走的机器人】
 * @Author : sunzhenning
 * @Since : 2022/6/7 10:20
 * 思路：使用方向数组
 */
public class WalkingRobotSimulation {

    public static void main(String[] args) {
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        int ans = walkingRobotSimulation.robotSim(commands, obstacles);
        System.out.println(ans);
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        //结果
        int ans = 0;
        //1.将障碍物的二维数组转换成一维hash散列值
        HashSet<Long> set = new HashSet<>();
        for(int i=0;i<obstacles.length;i++){
            int x = obstacles[i][0];
            int y = obstacles[i][1];
            set.add(calcHash(x,y));
        }
        //2.使用方向数组 N=0(dx[0],dy[0]),E=1(dx[1],dy[1]),S=2(dx[2],dy[2]),W=3(dx[3],dy[3])
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        //3.行走，x,y表示初始位置
        int x = 0;
        int y = 0;
        int dir = 0;//初始方向，向北。
        //外层循环。判断命令
        for(int i=0;i<commands.length;i++){
            int command = commands[i];
            if(command== -1){
                dir = (dir+1)%4;
            }else if(command == -2){
                dir = (dir+3)%4;
            }else{
                //内存循环，走步了
                for(int j=0;j<command;j++){
                    //方向数组已经给定了方向。nx和ny表示当前步骤的坐标
                    int nx = x+dx[dir];
                    int ny = y+dy[dir];
                    //判断当前位置是否是障碍物,
                    long obstacle = calcHash(nx,ny);
                    if(set.contains(obstacle)){
                        break;
                    }
                    //把最新的位置赋给x,y
                    x = nx;
                    y = ny;
                    //当前位置到原点（0，0）的距离的平方
                    ans = Math.max(ans,x*x+y*y);
                }
            }
        }
        return ans;
    }

    /**
     * 将x,y坐标hash一下，将数组变成字符串
     * @param x
     * @param y
     * @return
     */
//    private String calcHash(int x,int y){
//        return String.valueOf(x)+","+String.valueOf(y);
//    }

    /**
     * 将x,y坐标hash一下，将数组变成字long类型数字
     * @param x
     * @param y
     * @return
     */
    private long calcHash(int x,int y){
        return (x+3000)*60001+(y+3000);
    }
}
