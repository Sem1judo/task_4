//package ua.com.foxminded.task_4.logic;
//
//public class DivisionPro {
//
//    private static final String DELIMITER = "";
//    private static final String NEW_LINE = "\n";
//    private static final char NEW_LINE_CHAR = '\n';
//
//
//    private StringBuilder result = new StringBuilder();
//    private StringBuilder quotient = new StringBuilder();
//    private StringBuilder reminder = new StringBuilder();
//
//    public String makeDivision(int dividend, int divisor) {
//
//        if (divisor == 0) {
//            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
//        } else if ((divisor <= 0) || (dividend <= 0)) {
//            throw new IllegalArgumentException("Number cannot be negative");
//
//        }
//
//        if (dividend < divisor) {
//            double res = (double) dividend / divisor;
//            return "" + dividend + "/" + divisor + " = " + res;
//        }
//
//        String[] digits = String.valueOf(dividend).split(DELIMITER);
//        int reminderNumber;
//        int multiplyResult;
//        Integer mod;
//
//        for (int i = 0; i < digits.length; i++) {
//            reminder.append(digits[i]);
//            reminderNumber = Integer.parseInt(reminder.toString());
//
//            if (reminderNumber >= divisor) {
//                mod = reminderNumber % divisor;
//                multiplyResult = reminderNumber / divisor * divisor;
//
//                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber);
//                result.append(lastReminder).append(NEW_LINE);
//
//                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
//                result.append(multiply).append(NEW_LINE);
//
//                Integer moveLine = lastReminder.length();
//                result.append(getDivider(reminderNumber, moveLine)).append(NEW_LINE);
//
//                quotient.append(reminderNumber / divisor);
//
//                reminder.replace(0, reminder.length(), mod.toString());
//
//            } else  if (i >= divisor) {
//                quotient.append(0);
//            }
//            else if (i == digits.length - 1) {
//                result.append(String.format("%" + (i + 2) + "s", reminderNumber)).append(NEW_LINE);
//            }
//        }
//        return null;
//    }
//}
