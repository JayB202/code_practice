import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repearNum = scanner.nextInt();
        String script = scanner.next();
        scanner.close();

        int skillCnt = 0;
        List<Character> buffers = new ArrayList<>();
        Map<Character, Character> mappingSkill = new HashMap<>();
        mappingSkill.put('R', 'L');
        mappingSkill.put('K', 'S');

        for (int i = 0; i < repearNum; i++) {
            switch (script.charAt(i)) {
                case 'L':
                case 'S':
                    buffers.add(script.charAt(i));
                    break;
                case 'K':
                case 'R': {
                    if (buffers.isEmpty()) {
                        System.out.println(skillCnt);
                        return;
                    }

                    char readySkill = mappingSkill.get(script.charAt(i));
                    boolean isClear = true;
                    int size = buffers.size();

                    for (int j = 0; j < size; j++) {
                        char target = buffers.get(size - j - 1);
                        if (target == readySkill) {
                            int idx = size - j - 1;
                            buffers.remove(idx);
                            skillCnt++;
                            isClear = false;
                            break;
                        }
                    }

                    if (isClear) {
                        System.out.println(skillCnt);
                        return;
                    }
                    break;
                }
                default:
                    skillCnt++;
                    break;
            }
        }
        System.out.println(skillCnt);
    }
}