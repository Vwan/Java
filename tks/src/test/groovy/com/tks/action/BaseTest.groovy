package com.tks.action

import com.tks.repo.impl.GenericRepo
import rules.AbstractBaseRule
import spock.lang.Specification

import javax.servlet.ServletContext
/**
 * Created by wanjia on 2016/8/16.
 */
class BaseTest <T extends GenericRepo, U extends AbstractBaseRule> extends Specification{
    protected ServletContext context
    def setup() {
   /*     def session = Mockito.mock(HttpSession.class);
        def request = Mockito.mock(HttpServletRequest);
        context = new MockServletContext();
        context.setAttribute(AppServletContextListner.getClass().getSimpleName());
        MockContainer mc = MockContainer.newInstance();
      //  ActionProxy proxy = mc.getInstance(ActionProxyFactory.class).createActionProxy(
        //         namespace, name, method, extraContext, true, false);
        Map<String, Object> contextMap = new HashMap<String, Object>();
        contextMap.put(StrutsStatics.HTTP_REQUEST, request);
        ActionContext.setContext(new ActionContext(contextMap));
       // ServletActionContext.setContext(context);
       */
    }

}
