package factory.settings;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface Isettings {
    AbstractDriverOptions settings(String... args);
}
