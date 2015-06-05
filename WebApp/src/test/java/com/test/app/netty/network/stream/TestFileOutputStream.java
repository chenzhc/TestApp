package com.test.app.netty.network.stream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zc on 2015/6/5.
 */
public class TestFileOutputStream {

    @Test
    public void TestOutputStream() throws IOException {
        OutputStream out = null;
        try{
            out = new FileOutputStream("/home/user/temp/data.txt");
            generateCharacter(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

    public void generateCharacter(OutputStream out) throws IOException {
        int firstPrintableCharacter     = 33;
        int numberOfPrintableCharcter   = 94;
        int numberOfCharactersPerline   = 72;

        int start = firstPrintableCharacter;
        while(true){
            for(int i=start; i<start+numberOfCharactersPerline; i++){
                out.write((
                        (i-firstPrintableCharacter) % numberOfPrintableCharcter)
                        + firstPrintableCharacter
                        );
            }
            out.write('\r');
            out.write('\n');
            start = ((start+1) - firstPrintableCharacter)
                    % numberOfPrintableCharcter + firstPrintableCharacter;
            if(start>94){
                break;
            }
        }
    }
}
