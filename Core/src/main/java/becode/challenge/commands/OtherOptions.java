package becode.challenge.commands;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.Set;

public class OtherOptions {
    public static Options getOpt(Set<String> list) {
        Options otherOptions = new Options();
        int i = 1;
        for (String desc : list) {
            String optionName = "opt" + i;
            otherOptions.addOption(Option.builder(String.valueOf(i)).longOpt(optionName).hasArg().desc(desc).build());
            i++;
        }
        return otherOptions;
    }
}
