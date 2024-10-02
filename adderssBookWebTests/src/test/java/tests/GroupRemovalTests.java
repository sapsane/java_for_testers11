package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {





    @Test
    public void canRemoveGroup() {

        if (!app.groups().isGroupPresent()) {
            app.groups().CreateGroup(new GroupData("group name", "group header", "Group footer"));
        }
        app.groups().removeGroup();

    }

}
