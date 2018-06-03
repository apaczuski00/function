package paczuski.web.function.Creator;

import javassist.*;
import javassist.bytecode.ClassFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paczuski.web.function.dynamic.DynamicController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


@RestController
public class Creator {

    @Autowired
    private DynamicController dynamicController;


    @RequestMapping("create")
    String test() throws NoSuchMethodException, NotFoundException, CannotCompileException {

        Field[] fields = dynamicController.getClass().getDeclaredFields();
        Method[] methods = dynamicController.getClass().getDeclaredMethods();
        Method testFunction = dynamicController.getClass().getDeclaredMethod("testFunction");
        testFunction.setAccessible(true);

//        ClassFile cf = ClassPool.getDefault().get("paczuski.web.function.dynamic.dynamicController").getClassFile();
        CtClass cf = ClassPool.getDefault().get("paczuski.web.function.dynamic.dynamicController");
       // M//ethod restMethod = methods+
        CtMethod m = CtNewMethod.make(
                "public int xmove(int dx) { x += dx; }",
                cf);
        cf.addMethod(m);
        return "OK";
    }

}
