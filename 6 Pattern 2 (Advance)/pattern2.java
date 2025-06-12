public class pattern2 {

    //hollow rectangle
    public static void hollowRectangle(int num){
        for(int line = 1; line <= num; line++){
                    for(int col = 1; col <= num; col++){
                        if(line == 1 || line == num || col == 1 || col == num){
                        System.out.print(" *");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //Inverted  Rotated half-Pyramid
    public static void halfPyramid(int num){
        for(int line = 1; line <= num; line++){
            for(int col = 1; col <= num - line; col++){
                System.out.print(" ");
            }
            for(int col = num - line + 1; col <= num; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // Inverted half-Pyramid with numbers
    public static void pyramidWithNumber(int num){
        for(int line = 1; line <= num; line++){
            for(int col = 1; col <= num - line + 1; col++){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    //floyd's Triangle
    public static void floyd(int num){
        int i = 1;
        for(int line = 1; line <= num; line++){
            for(int col = 1 ; col <= line; col++){
                System.out.print(i++ + " ");
            }
            System.out.println();
        }
    }

    // 0-1 triangle
    public static void zeroOne(int num){
        int i = 1;
        for(int line = 1; line <=num; line++){

            for(int col = 1; col <= line ; col++){
                if(i % 2 == 0){
                    System.out.print(0);
                } else{
                    System.out.print(1);
                }
                i++;
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int num){
        for(int line = 1; line<=num; line++){
            for(int col = 1; col <= num; col++){
                if(col <= line){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            for(int col =1; col<= (num -line); col++){
                System.out.print(" ");
            }
            for(int col = 1; col<= line; col++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int line = 1; line<=num; line++){
            for(int col =1; col <=num - line+1; col++){
                System.out.print("*");
            }
            for(int col = 1; col<= line -1;col++){
                System.out.print(" ");
            }
            for(int col = 1; col <= line-1; col++){
                System.out.print(" ");
            }
            for(int col = 1; col<= (num -line)+1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // optimal Butterfly pattern
    public static void optimalButterfly(int num){
        //1st half
        for(int line = 1;line <= num; line++){
            //star
            for(int col = 1;col<=line; col++){
                System.out.print("*");
            }
            //spaces 
            for(int col =1; col<= 2*(num - line); col++){
                System.out.print(" ");
            }
            //stars
            for(int col =1; col<=line; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half or mirror image
        for(int line = num; line >=1; line--){
             //star
             for(int col = 1;col<=line; col++){
                System.out.print("*");
            }
            //spaces 
            for(int col =1; col<= 2*(num - line); col++){
                System.out.print(" ");
            }
            //stars
            for(int col =1; col<=line; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //solid rohmbus
    public static void solidRhombus(int num){
        for(int line = 1; line <= num; line++){
            for(int col=1; col<= num-line; col++){
                System.out.print(" ");
            }
            for(int col = 1; col<= 5; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // hollow Rhombus
    public static void hollowRhombus(int num){
        for(int line = 1; line <= num; line++){
            for(int col = 1; col <= num-line; col++){
                System.out.print(" ");
            }
            for(int col = 1;col<= 5; col++){
                if(line == 1 || line == num || col == 1 || col == 5){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //Diamond Pattern
    public static void diamond(int num){
        for(int line = 1; line<= num; line++){
            for(int col = 1; col <= num-line; col++){
                System.out.print(" ");
            }
            for(int col = 1;col <= 2*line - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int line = num; line >= 1; line--){
            for(int col = 1; col <= num-line; col++){
                System.out.print(" ");
            }
            for(int col = 1;col <= 2*line - 1; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        // hollowRectangle(10);
        // halfPyramid(5);
        // pyramidWithNumber(5);
        // floyd(5);
        // zeroOne(5);
        // butterflyPattern(4);
        // optimalButterfly(4);
        // solidRhombus(5);
        // hollowRhombus(5);
        diamond(5);
    }
}
