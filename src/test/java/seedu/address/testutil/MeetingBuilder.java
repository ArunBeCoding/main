package seedu.address.testutil;

import static java.util.Objects.requireNonNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.commons.util.DateTimeUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.calendar.Meeting;
import seedu.address.model.member.MemberName;

/**
 * A utility class to help with building {@code Task} objects.
 */
public class MeetingBuilder {

    public static final LocalDateTime DEFAULT_DATE_TIME;
    public static final Duration DEFAULT_DURATION = Duration.ofHours(2);

    static {
        LocalDateTime tmp = null;
        try {
            tmp = DateTimeUtil.parseDateTime("11-11-2019 18:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DEFAULT_DATE_TIME = tmp;
    }

    private LocalDateTime startTime;
    private Duration duration;
    private List<MemberName> memberNameList;

    public MeetingBuilder() {
        startTime = DEFAULT_DATE_TIME;
        duration = DEFAULT_DURATION;
        memberNameList = new ArrayList<>();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public MeetingBuilder(Meeting meetingToCopy) {
        requireNonNull(meetingToCopy);
        startTime = meetingToCopy.getStartTime();
        duration = meetingToCopy.getDuration();
        memberNameList = new ArrayList<>(meetingToCopy.getMemberNameList());
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public MeetingBuilder withStartTime(LocalDateTime startTime) throws ParseException {
        this.startTime = DateTimeUtil.parseDateTime(DateTimeUtil.displayDateTime(startTime));
        return this;
    }

    /**
     * Sets the {@code TaskStatus} of the {@code Task} that we are building.
     */
    public MeetingBuilder withDuration(Duration duration) {
        this.duration = Duration.parse(duration.toString());
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are building.
     */
    public MeetingBuilder withMembers(List<MemberName> memberNameList) {
        this.memberNameList = memberNameList
                            .stream()
                            .map(x -> new MemberName(x.fullName))
                            .collect(Collectors.toList());
        return this;
    }


    public Meeting build() {
        return new Meeting(startTime, duration, memberNameList);
    }

}