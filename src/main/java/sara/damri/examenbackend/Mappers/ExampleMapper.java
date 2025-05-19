package sara.damri.examenbackend.Mappers;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sara.damri.examenbackend.DTOs.ExampleDTO;
import sara.damri.examenbackend.Entities.Example;

@Service
public class ExampleMapper {
    public ExampleDTO fromExample(Example example) {
        ExampleDTO example1 = new ExampleDTO();
        BeanUtils.copyProperties(example, example1);
        return example1;
    }
    public Example fromExampleDTO(ExampleDTO exampleDTO) {
        Example example = new Example();
        BeanUtils.copyProperties(example, example);
        return example;
    }
}
