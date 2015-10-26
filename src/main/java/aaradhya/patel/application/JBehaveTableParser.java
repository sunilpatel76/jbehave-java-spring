package aaradhya.patel.application;

import org.jbehave.core.io.ResourceLoader;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;


public class JBehaveTableParser extends ExamplesTableFactory{

    public JBehaveTableParser(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

//    public ExamplesTable examplesTable(String inputTable){
//        String[] inputData = inputTable.split("\n");
//        inputTable = inputData[0];
////        try {
////            StoryTableConfig.
////        }
//    }

}
