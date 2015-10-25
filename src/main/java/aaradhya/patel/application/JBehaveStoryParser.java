package aaradhya.patel.application;


import org.jbehave.core.model.Story;
import org.jbehave.core.parsers.RegexStoryParser;

import java.util.HashMap;
import java.util.Map;

public class JBehaveStoryParser extends RegexStoryParser{
    private static final Map<String, Story> storyMap = new HashMap<String, Story>();

    public JBehaveStoryParser(){
        super();
    }

    public Story parseStory(String storyText, String storyPath){
        Story story;
        if (storyMap.containsKey(storyPath)){
            story = storyMap.remove(storyPath);
        }else{
            story = super.parseStory(storyText,storyPath);
            storyMap.put(storyPath, story);
        }
        return story;
    }
}
