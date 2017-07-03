package com.tks.action

import com.tks.entity.Language
import com.tks.repo.BaseRepoTest
import com.tks.repo.impl.LanguageRepo
import com.tks.web.action.LanguageAction
import rules.entity.LanguageRule
/**
 * Created by wanjia on 2016/8/16.
 */
class LanguageActionTest extends BaseRepoTest<LanguageRepo,LanguageRule> {

    def setup(){
    }

    def "test create Language"(){
        setup:
            def language = rule.getEntity();
            System.out.println("+++++"+language);
            def languageAction = new LanguageAction();
            languageAction.setEntity(language);
        when:
             def result = languageAction.create();
        then:
           result=="success";
    }

    def "find all Language"(){
        when:
            def languageAction = new LanguageAction();
            def result = languageAction.listAll()
             System.out.println("result is: "+languageAction.datamap);
        then:
            result!=null
    }

    def "delete Language"(){
        when:
        def language = rule.getEntity();
        def languageAction = new LanguageAction();
        languageAction.setEntity(language);
        def result = languageAction.delete();
        System.out.println("result is: "+languageAction.datamap);

        then:
        result!="error"
    }

    def "F - delete non- exiting Language"(){
        when:
        def language = new Language("non-exisitnt","non existing")
        def languageAction = new LanguageAction();
        languageAction.setEntity(language);
        def result = languageAction.delete();
        System.out.println("result is: "+languageAction.datamap);

        then:
        result=="error"
    }

    def "update Language"(){
        when:
        def language = rule.getEntity();
        language.setCode("Modified")
        language.setName("name modified");
        def languageAction = new LanguageAction();
        languageAction.setEntity(language);
        def result = languageAction.update();
        System.out.println("result is: "+languageAction.datamap);

        then:
        result!="error"

    }
}
