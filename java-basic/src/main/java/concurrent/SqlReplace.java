package concurrent;

import java.util.Stack;

public class SqlReplace {

    /**
     * select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?
     *
     *
     * select * from tbl where col1 = $1 and (col2 = $2 or col3 like $3) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = $4
     * @param args
     */
    public static void main(String[] args) {
        String sql = "select * from tbl where col1 = ? and (col2 = ? or col3 like ?) and col4 = ' 你是怎么了 ? 快起来呀' and col5 = ?";
        String result = convertSql(sql);
        System.out.println(result);
    }


    public static String convertSql(String sql){
        char[] c = sql.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '\''){
                if(stack.isEmpty()) {
                    stack.push(c[i]);
                }else {
                    stack.pop();
                }
            }
            if(c[i] == '?' && stack.isEmpty()){
                builder.append("$").append(count++);
            }else {
                builder.append(c[i]);
            }
        }

        return builder.toString();
    }

}
