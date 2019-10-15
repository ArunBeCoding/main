package seedu.address.model.member;

/**
 * Represents a Member's ID in the address book.
 * Guarantees: Field values are validated, immutable.
 */
public class MemberId {
    public static final String MESSAGE_CONSTRAINTS =
            "Invalid member ID, please enter a alphanumeric code";
    public static final String VALIDATION_REGEX = "[\\p{Alpha}]*";
    private String displayId;

    /**
     * Enum constructor to give UI-friendly display names.
     * Cannot be called by other components.
     *
     * @param displayId an alternate name for the member ID
     */
    public MemberId(String displayId) {
        this.displayId = displayId;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidId(String test) {
        return test.matches(VALIDATION_REGEX);
    }    

    public String getDisplayName() {
        return this.displayId;
    }
}
