package rules.entity;

import com.tks.entity.Language;
import com.tks.repo.impl.LanguageRepo;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by wanjia on 2016/8/12.
 */
public class LanguageRule extends BaseTestRule<Language,LanguageRepo> {


    public void generate(){
        //entity = new Status ("IN PROGRESS111","IN PROGRESS111");
        entity=new Language(RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false));
        System.out.println(entity.toString());

    }


    public static void main(String[] args){
        LanguageRule lr = new LanguageRule();
        lr.generate();
        LanguageRepo lrrepo=new LanguageRepo();
        lrrepo.setEntity(lr.getEntity());
    //    lrrepo.save(lr.getEntity());
      //  lrrepo.close();
    }

}
