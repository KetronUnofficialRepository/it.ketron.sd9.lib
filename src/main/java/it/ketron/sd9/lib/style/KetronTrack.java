package it.ketron.sd9.lib.style;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * A track contains a sequence of midi events for the different channels
 *
 * e.g.: Tick: @232320, Channel: 8, Note on, D#2 key=39 velocity: 62
 */
@Data
@Slf4j
@NoArgsConstructor
@EqualsAndHashCode
public class KetronTrack {
    private KetronTrackIdentifier trackIdentifier;
}
