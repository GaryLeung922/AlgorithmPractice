package cn.xiaojiaqi.myNowcoderPractice.advanced_part01;

/**
 * @Author: liangjiaqi
 * @Date: 2020/7/9 10:14 PM
 */
public class Code_03_Manacher_02 {

    public int manacherString(String str){
        String string = replaceStr(str);
        char[] chars = string.toCharArray();
        int[] p = new int[string.length()];
        int L = 0;
        int R = 0;
        int c = 0;
        int cur = 1;
        int most = 0;
        while(R < p.length-1){
            if(cur>=R){
                int mostRight = mostRight(chars, cur, cur+1);
                if(mostRight>R){
                    R = mostRight;
                    L = cur - (mostRight-cur);
                    c = cur;
                    most = Math.max(most,mostRight-cur);
                }
                p[cur] = mostRight-cur;
            }else{
                int scur = c - (cur-c);
                if(scur - p[scur] > L){
                    p[cur] = p[scur];
                }else if(scur - p[scur] < L){
                    p[cur] = scur-L;
                }else {
                    int mostRight = mostRight(chars, cur, R+1);
                    if(mostRight>R){
                        R = mostRight;
                        L = cur - (mostRight-cur);
                        c = cur;
                        most = Math.max(most,mostRight-cur);
                    }
                    p[cur] = mostRight-cur;
                }
            }
            cur++;
        }
        System.out.println(most);
        return most>>1;
    }

    // brute extend
    public int mostRight(char[] chars, int i, int m){
        int n = i-(m-i);
        while(m<chars.length && n>=0){
            if(chars[n] == chars[m]){
                n--;
                m++;
            }else{
                break;
            }
        }
        return m-1;
    }

    public String replaceStr(String str){
        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : cs){
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');
        return sb.toString();
    }

    public static void main(String[] args) {

        Code_03_Manacher_02 c  =new Code_03_Manacher_02();

        int i = c.manacherString("bananas");

        String s = "1232";
        String s1 = s.substring(4);
        System.out.println(s1);
        StringBuilder sb = new StringBuilder();

        System.out.println(i);
    }



}
