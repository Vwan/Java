package com.tks.repo

import com.tks.entity.Release
import com.tks.repo.impl.ReleaseRepo
import com.tks.service.impl.ReleaseService
import rules.entity.ReleaseRule
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class ReleaseRepoTest extends BaseRepoTest<ReleaseRepo,ReleaseRule> {
    Release Release
    def setup(){
    }
    def teardown(){

    }

    @Unroll("create new Release in db, expecting #result")
    def "P: Create New Release"(){
        setup:
        expect:
        System.out.println("repo entity is:"+repo.getEntity())
        rule.createAndVerify(repo);
    }

    @Unroll("create Release existing already in db, expecting #result")
    def "F: Create Release existing already "(){
        setup:
        rule.createAndVerify(repo);

        when:
        repo.create(repo.getEntity());

        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find Release by name,expecting #result")
    def "P: Find Release by Name"(){
        when:
        Release release =(Release)new ReleaseService().findSingleByFieldName("name",repo.getEntity().getName());

        then:
        //rule.verifyFindByFieldName(repo,"nameAbbr",repo.getEntity().getNameAbbr());
        System.out.println(release.getId())

    }

    @Unroll("Zero Found: find Release by name,expecting #result")
    def "F: Find Release by Name"(){
        when:
        Release release =(Release)new ReleaseService().findSingleByFieldName("name","uft 12.54");

        then:
        //def ex = thrown(NoResultException)
        release==null

    }
    @Unroll("Find All Release,expecting #result")
    def "P: Find All Release"() {
        setup:
        rule.createAndVerify(repo);

        expect:
        List<Release> Release = rule.verifyFindAll(repo, repo.count());
        for (Release s : Release) {
        System.out.println("result is:" + s)
    }
    }
}
