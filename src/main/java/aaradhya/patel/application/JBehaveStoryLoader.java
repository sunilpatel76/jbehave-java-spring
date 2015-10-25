package aaradhya.patel.application;


import org.jbehave.core.io.InvalidStoryResource;
import org.jbehave.core.io.LoadFromClasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JBehaveStoryLoader extends LoadFromClasspath{
    
    public JBehaveStoryLoader(){
        super();
    }
    
    public String loadResourceAsText(String storyPath){
        StringBuilder stringBuilder = new StringBuilder();
        String lineStr;

        try {
            InputStreamReader streamReader = new InputStreamReader(resourceAsStream(storyPath), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            while ((lineStr = bufferedReader.readLine()) != null){
                stringBuilder.append(lineStr).append("\n");
            }
        }catch (IOException e){
            throw new InvalidStoryResource(storyPath, e);
        }
        return stringBuilder.toString();
    }

}
