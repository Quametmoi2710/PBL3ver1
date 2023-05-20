package com.example.demo.SERVICE;
import com.example.demo.ENTITY.ParentCategory;
import com.example.demo.REPOSITOTY.ParentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ParentCategoryService {
    @Autowired private ParentCategoryRepository parentCategoryRepository;
    public List<ParentCategory> listAll(){
        return (List<ParentCategory>) this.parentCategoryRepository.findAll();
    }
    public void saveParentCategory(ParentCategory parentCategory){
        this.parentCategoryRepository.save(parentCategory);
    }
    public ParentCategory getById(Integer id){
        Optional<ParentCategory> result = this.parentCategoryRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.parentCategoryRepository.deleteById(id);
    }
}
