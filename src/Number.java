/**
 * 阿拉伯数字转中文表示
 * ¥1011 -> 一千零一拾一元整
 * @author burtbai
 */
public class Number {

    private static final String[] unitTable = {"", "拾", "佰", "千", "万"};
    private static final String[] numberTable = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static String convert(int number) {
        if (number < 0 || number > 100000) {
            // except
            return "";
        }

        if (number == 0) {
            return "零";
        }

        String result = "";
        int temp;
        int index = 0;
        while (number > 0) {
            temp = number % 10;
            if (temp == 0 && !result.startsWith("零")) {
                result = "零" + result;
            } else if (temp != 0) {
                result = numberTable[temp] + unitTable[index] + result;
            }
            index++;
            number /= 10;
        }

        if (result.endsWith("零")) {
            result = result.substring(0, result.length() - 1);
        }

        return result + "元整";
    }

    public static void main(String[] args) {
        String test1 = convert(1011);
        String test2 = convert(10001);
        String test3 = convert(10100);
        String test4 = convert(1);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
    }
}
