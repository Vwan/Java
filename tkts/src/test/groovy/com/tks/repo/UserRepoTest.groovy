package com.tks.repo

import com.tks.entity.User
import com.tks.repo.impl.UserRepo
import rules.entity.UserRule
import spock.lang.Unroll
/**
 * Created by wanjia on 2016/8/7.
 */
public class UserRepoTest extends BaseRepoTest<UserRepo,UserRule> {
    User user
    def setup(){
    }
    def teardown(){

    }

    @Unroll("create new user in db, expecting #result")
    def "P: Create New user"(){
        setup:
        expect:
        System.out.println("repo entity is:"+repo.getEntity())
        rule.createAndVerify(repo);
    }

    @Unroll("create user existing already in db, expecting #result")
    def "F: Create user existing already "(){
        setup:
        rule.createAndVerify(repo);
        when:
        repo.create(repo.getEntity());
        then:
        def ex = thrown(IllegalArgumentException)
    }

    @Unroll("find user by name,expecting #result")
    def "P: Find user by Name"(){
        expect:
        rule.verifyFindByFieldName(repo,"name",repo.getEntity().getName());

    }
    @Unroll("Find All user,expecting #result")
    def "P: Find All user"() {
        setup:
        rule.createAndVerify(repo);
        expect:
        List<User> users = rule.verifyFindAll(repo, repo.count());
        for (User s : users) {
            System.out.println("result is:" + s)
        }
    }
}
