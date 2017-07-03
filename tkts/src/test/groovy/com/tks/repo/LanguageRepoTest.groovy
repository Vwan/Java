package com.tks.repo

import com.tks.entity.Language
import com.tks.repo.impl.LanguageRepo
import rules.entity.LanguageRule
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class LanguageRepoTest extends BaseRepoTest<LanguageRepo,LanguageRule> {

    def setup(){
    }
    def teardown(){

    }

    @Unroll("create new Language in db, expecting #result")
    def "P: Create New Language"(){
        setup:
        expect:
        System.out.println("repo entity is:"+repo.getEntity())
        rule.createAndVerify(repo);
    }

    @Unroll("create Language existing already in db, expecting #result")
    def "F: Create Language existing already "(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.create(repo.getEntity());
        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find Language by name,expecting #result")
    def "P: Find Language by Name"(){
        expect:
        rule.verifyFindByFieldName(repo,"code",repo.getEntity().getCode());

    }
    @Unroll("Find All Language,expecting #result")
    def "P: Find All Language"() {
        setup:
        rule.createAndVerify(repo);
        expect:
        List<Language> Language = rule.verifyFindAll(repo, repo.count());
        for (Language s : Language) {
        System.out.println("result is:" + s)
    }
    }
}
