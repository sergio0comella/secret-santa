package it.panezio.secretsanta.configs;

import it.panezio.secretsanta.dto.MemberDto;
import it.panezio.secretsanta.models.Member;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class ModelMapperConfig
{
    @Bean
    public ModelMapper modelMapper()
    {
        ModelMapper modelMapper = new ModelMapper();
        //ignore null value from persistence layer
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        //modelMapper.addMappings(membersMapping); TODO Fix mapping DTO
        modelMapper.addConverter(memberConverter);

        return modelMapper;
    }


    PropertyMap<Member, MemberDto> membersMapping = new PropertyMap<>() {
        protected void configure() {
            List<String> groupIds = new ArrayList<>();
            source.getGroups().forEach(group -> {
                groupIds.add(group.getId());
            });
            destination.setGroups(groupIds);
        }
    };

    Converter<String, String> memberConverter = new Converter<String, String>() {
        @Override
        public String convert(MappingContext<String, String> context) {
            return context.getSource() == null ? "" : context.getSource().trim();
        }
    };

}
