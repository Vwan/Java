import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wanjia on 2017/10/11.
 */
public class DateToLocal {

        public static void main(String[] args){
            Locale l = Locale.FRENCH ;
            Date date = new Date("10/10/2017 08:49:01");
            LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            String dateTime = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            System.out.printf("Successfully parsed, date is %s%n", dateTime);
        }
    }

