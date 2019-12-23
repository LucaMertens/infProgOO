package programming.set8.length;

/** Holds muliple very useful lengths. */
public enum Length {
    /** A shin that can be viewed in augmented reality. */
    ARSHIN(0.71),
    /** Don't pull it. */
    FINGER(0.022225),
    /**
     * The metre (Commonwealth spelling and BIPM spelling) or meter (American
     * spelling) (from the French unit mètre, from the Greek noun μέτρον, "measure")
     * is the base unit of length in the International System of Units (SI). The SI
     * unit symbol is m. The metre is defined as the length of the path travelled by
     * light in a vacuum in 1 / 299,792,458 of a second.
     * 
     * The metre was originally defined in 1793 as one ten-millionth of the distance
     * from the equator to the North Pole along a great circle, so the Earth's
     * circumference is approximately 40,000 km. In 1799, the metre was redefined in
     * terms of a prototype metre bar (the actual bar used was changed in 1889). In
     * 1960, the metre was redefined in terms of a certain number of wavelengths of
     * a certain emission line of krypton-86. In 1983, the current definition was
     * adopted.
     * 
     * Metre is the standard spelling of the metric unit for length in nearly all
     * English-speaking nations except the United States and the Philippines, which
     * use meter. Other Germanic languages, such as German, Dutch, and the
     * Scandinavian languages likewise spell the word meter.
     * 
     * Measuring devices (such as ammeter, speedometer) are spelled "-meter" in all
     * variants of English. The suffix "-meter" has the same Greek origin as the
     * unit of length.
     * 
     * The etymological roots of metre can be traced to the Greek verb μετρέω
     * (metreo) (to measure, count or compare) and noun μέτρον (metron) (a measure),
     * which were used for physical measurement, for poetic metre and by extension
     * for moderation or avoiding extremism (as in "be measured in your response").
     * This range of uses is also found in Latin (metior, mensura), French (mètre,
     * mesure), English and other languages. The motto ΜΕΤΡΩ ΧΡΩ (metro chro) in the
     * seal of the International Bureau of Weights and Measures (BIPM), which was a
     * saying of the Greek statesman and philosopher Pittacus of Mytilene and may be
     * translated as "Use measure!", thus calls for both measurement and moderation.
     * The use of the word metre (for the French unit mètre) in English began at
     * least as early as 1797.
     * 
     * In 1671 Jean Picard measured the length of a "seconds pendulum" (a pendulum
     * with a period of two seconds) at the Paris observatory. He found the value of
     * 440.5 lines of the Toise of Châtelet which had been recently renewed. He
     * proposed a universal toise (French: Toise universelle) which was twice the
     * length of the seconds pendulum. However, it was soon discovered that the
     * length of a seconds pendulum varies from place to place: French astronomer
     * Jean Richer had measured the 0.3% difference in length between Cayenne (in
     * French Guiana) and Paris.
     * 
     * Jean Richer and Giovanni Domenico Cassini measured the parallax of Mars
     * between Paris and Cayenne in French Guiana when Mars was at its closest to
     * Earth in 1672. They arrived at a figure for the solar parallax of 9.5
     * arcseconds, equivalent to an Earth–Sun distance of about 22000 Earth radii.
     * They were also the first astronomers to have access to an accurate and
     * reliable value for the radius of Earth, which had been measured by their
     * colleague Jean Picard in 1669 as 3269 thousand toises. Picard's geodetic
     * observations had been confined to the determination of the magnitude of the
     * Earth considered as a sphere, but the discovery made by Jean Richer turned
     * the attention of mathematicians to its deviation from a spherical form. In
     * addition to its significance for cartography, the determination of the Figure
     * of the Earth became a problem of the highest importance in astronomy,
     * inasmuch as the diameter of the Earth was the unit to which all celestial
     * distances had to be referred.
     * 
     * Source: https://en.wikipedia.org/wiki/Metre.
     */
    METRE(1.0),
    /** Christmas is neigh. */
    HORSE_LENGTH(2.4),
    /**
     * The distance at which one astronomical unit subtends an angle of one
     * arcsecond (I totally understand what that means).
     */
    PARSEC(30_856_776_000_000_000.0),
    /** The radius of Mickey Mouse's dog. */
    PLUTO_RADIUS(1_186_000.0);

    /** How long one unit of this length would be in meters. */
    private double lengthInMeters;

    /**
     * Constructs a length.
     * 
     * @param lengthInMeters How long one unit of this length would be in meters.
     */
    Length(double lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    /**
     * Returns how much one of this unit is in metres.
     * 
     * @return one unit in metres.
     */
    public double getUnitLengthInMetres() {
        return this.lengthInMeters;
    }

    /**
     * Converts the given amount measured in the current length unit to how much it
     * would be in the target unit.
     * 
     * @param targetLength the target unit of length.
     * @param amount       the length to convert to the target length.
     * @return the corresponding length in the target unit.
     */
    public double convertTo(Length targetLength, double amount) {
        return this.getUnitLengthInMetres() * amount / targetLength.getUnitLengthInMetres();
    }
}