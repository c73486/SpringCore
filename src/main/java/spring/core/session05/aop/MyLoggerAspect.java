package spring.core.session05.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面程式Aspect
//執行Log紀錄的相關公用邏輯
@Component // 可以被spring來管理
@Aspect // 告訴spring說此為一個切面程式
@Order(1) // 調用的順序(順序越小越先被執行)
public class MyLoggerAspect {

	// 建立一個切入點的邏輯方法
	// value = "切入點表達式"
	@Pointcut(value = "execution(public Integer spring.core.session05.aop.CalcImpl.add(..))")
	public void pt() {

	}

	@Pointcut(value = "execution(public Integer spring.core.session05.aop.CalcImpl.div(..))")
	public void pt2() {

	}

	@Pointcut(value = "execution(public Integer spring.core.session05.aop.CalcImpl.*(..))")
	public void pt3() {

	}

	@Pointcut(value = "@annotation(spring.core.session05.aop.MyLoggerAnnotation)")
	public void pt4() {

	}

	@Pointcut(value = "bean(calcImpl)") // 在名為calcImpl的spring bean中的任何方法進行攔截
	public void pt5() {

	}

	@Pointcut("initialization(spring.core.session05.aop.CalcImpl.new(..))")//冷門
	public void pt6() {

	}

	// 前置通知(advice) 執行到哪個部分所設路徑
	// @Before(value = "execution(public Integer
	// spring.core.session05.aop.CalcImpl.add(Integer,Integer))") //注入指定方法簽章
	// @Before(value = "execution(public Integer
	// spring.core.session05.aop.CalcImpl.add(..))") //注入指定方法簽章,不限制方法參數
	// @Before(value = "execution(public Integer
	// spring.core.session05.aop.CalcImpl.*(..))") //不指定方法名稱,不限制方法參數
	// @Before(value = "execution(* spring.core.session05.aop.CalcImpl.*(..))")
	// //不限權限 不限回傳值 不指定方法名稱,不限制方法參數
	// @Before(value = "execution(* spring.core.session05.aop.*.*(..))") //不限權限
	// 不限回傳值 不限類別 不指定方法名稱,不限制方法參數
	// @Before(value = "execution(* *(..))") //全部攔截 都不限制
	// @Before(value = "pt2()") //全部攔截 都不限制
	// @Before(value = "pt3() && !pt2()")//切入點表達式支援邏輯運算子 && || !
	//@Before(value = "pt5()")
	@Before(value = "pt5()")
	public void beforeAdvice(JoinPoint joinPoint) {// JoinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 得到JoinPoint連接點的方法名稱
		Object[] args = joinPoint.getArgs(); // 得到JoinPoint得到連接點的方法參數
		System.out.printf("呼叫前置通知-JoinPoint連接點的方法名稱: %s 方法參數: %s%n", methodName, Arrays.toString(args));
	}

	// 後置通知(不論是否會發生異常都會執行 所以後置通知在spring-AOP 機制上會自動放在finally區段中)
	@After(value = "pt5()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();// 得到JoinPoint連接點的方法名稱
		System.out.printf("後置通知 - JoinPoint連接點的方法名稱: %s%n", methodName);
	}

	// 返回通知(可以設定 returning來得到方法的回傳值)
	// 不過若有異常發生 則返回通知不會執行
	@AfterReturning(value = "pt5()", returning = "result")
	public void afterReturingAdvice(Object result) {// 得到返回的資料型態統一用Object
		System.out.println("返回為通知");
	}

	// 異常通知(可以設定 throwing 來得到異常的錯誤資訊)
	@AfterThrowing(value = "pt5()", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName(); // 得到 JoinPoint 連接點的方法名稱
		Object[] args = joinPoint.getArgs(); // 得到 JoinPoint 連接點的方法參數
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		System.out.printf("%s 呼叫異常通知 - 方法名稱: %s 方法參數: %s 錯誤類型: %s 錯誤原因: %s%n", sdf.format(new Date()), methodName,
				Arrays.toString(args), ex.getClass().getSimpleName(), ex.getMessage());
	}

}
