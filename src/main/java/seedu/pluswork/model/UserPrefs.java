package seedu.pluswork.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.pluswork.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path projectDashboardFilePath = Paths.get("data", "projectdashboard.json");
    private Path userSettingsFilePath = Paths.get("data", "plusworksettings.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {
    }

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setProjectDashboardFilePath(newUserPrefs.getProjectDashboardFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getProjectDashboardFilePath() {
        return projectDashboardFilePath;
    }

    public Path getUserSettingsFilePath() {
        return userSettingsFilePath;
    }

    public void setProjectDashboardFilePath(Path projectDashboardFilePath) {
        requireNonNull(projectDashboardFilePath);
        this.projectDashboardFilePath = projectDashboardFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && projectDashboardFilePath.equals(o.projectDashboardFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, projectDashboardFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + projectDashboardFilePath);
        return sb.toString();
    }

}
