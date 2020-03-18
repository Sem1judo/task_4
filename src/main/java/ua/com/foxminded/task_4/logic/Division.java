package ua.com.foxminded.task_4.logic;

public class Division {

    private static final String DELIMITER = "";

    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder reminder = new StringBuilder();

    public String makeDivision(int dividend, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0, division by zero");
        } else if ((divisor < 0) || (dividend < 0)) {
            throw new IllegalArgumentException("Number cannot be negative");

        }

        if (dividend < divisor) {
            double res = (double) dividend/divisor;
            return "" + dividend + "/" + divisor + " = " + res;
        }

        String[] digits = String.valueOf(dividend).split(DELIMITER);
        int reminderNumber;
        int multiplyResult;
        Integer mod;

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= divisor) {
                mod = reminderNumber % divisor;
                multiplyResult = reminderNumber / divisor * divisor;

                String lastReminder = String.format("%" + (i + 2) + "s", "_" + reminderNumber);
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                result.append(multiply).append("\n");

                Integer fraction = lastReminder.length() - calculateDigit(multiplyResult);
                result.append(getDivider(reminderNumber, fraction)).append("\n");

                quotient.append(reminderNumber / divisor);

                reminder.replace(0, reminder.length(), mod.toString());
                
            } else  if (i >= divisor) {
                quotient.append(0);
            }
             else if (i == digits.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", reminderNumber)).append("\n");
            }
        }
        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private String getDivider(Integer reminderNumber, Integer borderLength) {
        return lpad(borderLength, ' ') + lpad(calculateDigit(reminderNumber), '-');
    }

    private void modifyResultToView(Integer dividend, Integer divisor) {
        int[] index = new int[3];
        int quantityPasses = 3;
        for (int startLine = 0, counter = 0; startLine < result.length(); startLine++) {
                if (result.charAt(startLine) == '\n') {
                index[counter] = startLine;
                counter++;
            }
            if (counter == quantityPasses) {
                break;
            }
        }

        int borderLength = calculateDigit(dividend) + 1 - index[0];
        result.insert(index[2], lpad(borderLength, ' ') + "│" + quotient.toString());
        result.insert(index[1], lpad(borderLength, ' ') + "│" + lpad(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    private int calculateDigit(int countDigit) {
        return (int) Math.log10(countDigit) + 1;
    }

    private String lpad(int quantityOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < quantityOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }
}
