package dataDrivenTestPackage;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class BaseClass {

	//public static WebDriver driver;
	// ExcelReading reader = new ExcelReading();
	public static Properties prop;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String uuid;
	public static int month;
	public static int year;
	public static int sec;
	public static int min;
	public static int date;
	public static int hour;

	public static String generateUniqueNumber() {
		// return uuid = UUID.randomUUID().toString();

		/*
		 * Random rand = new Random(); int maxNumber = 5; int randomNumber =
		 * rand.nextInt(maxNumber) + 1; return randomNumber;
		 */

		Calendar cal = new GregorianCalendar();
		// Month value is always 1 less than actual. For February, MONTH would return 1
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		sec = cal.get(Calendar.MILLISECOND);
		min = cal.get(Calendar.MINUTE);
		date = cal.get(Calendar.DATE);
		hour = cal.get(Calendar.HOUR_OF_DAY);
		String value = "Date_"+date + "_" + year +"_Time_"+hour + "_" + min;
		return value;
	}

	static {
		String value = generateUniqueNumber();
		//System.out.println("Running testReport");
		String dest = System.getProperty("user.dir") + "\\ExtentReport\\" + value + ".html";
		//System.out.println(dest);
		reporter = new ExtentSparkReporter(dest);
		// System.out.println(value);
		reporter.config().setDocumentTitle("Automation test Report");
		reporter.config().setReportName("TestReport");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("user", "Ashim");
	
	}

}
