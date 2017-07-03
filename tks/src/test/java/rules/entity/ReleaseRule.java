package rules.entity;

import com.tks.entity.Language;
import com.tks.entity.Product;
import com.tks.entity.Release;
import com.tks.repo.impl.ReleaseRepo;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanjia on 2016/8/12.
 */
public class ReleaseRule extends BaseTestRule<Release,ReleaseRepo> {

    private  LanguageRule languageRule = new LanguageRule();
    private ProductRule productRule = new ProductRule();

    public void before(){
        super.before();
        languageRule.before();
        productRule.before();
    }

    public void after(){
        super.after();
        languageRule.after();
        productRule.after();
    }

    public void generate(){
        languageRule.generate();
        Language language = languageRule.getEntity();
        Set<Language> langs = new HashSet<>();
        langs.add(language);
        languageRule.getRepo().create(language);
        System.out.println("language in Releaserule: "+language);

        productRule.generate();
        Product product = productRule.getEntity();
        productRule.getRepo().create(product);
        System.out.println("product in Releaserule: "+product);
        entity = new Release (RandomStringUtils.random(5,true,false), RandomStringUtils.random(5,true,false),product);
        entity.setLanguages(langs);
        System.out.println("Release in rule:"+entity.toString());
        repo.setEntity(entity);
        System.out.println("Release repo in rule:"+repo.getEntity());

    }
    public ReleaseRule(){

    }
}
