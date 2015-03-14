package com.poorjar.sqlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the Track table.
 * @author Swaroop
 */
@Entity
@Table(name = "Track")
public final class Track
{
    private long trackId;
    private String name;
    private String composer;

    public Track()
    {
    }

    /**
     * @param trackId The unique track id.
     * @param title The name of the track.
     * @param description The composer of the track.
     */
    public Track(long trackId, String name, String composer)
    {
        super();
        this.trackId = trackId;
        this.name = name;
        this.composer = composer;
    }

    /**
     * @return the trackId
     */
    @Id
    @Column(name = "TrackId", unique = true, nullable = false)
    public final long getTrackId()
    {
        return trackId;
    }

    /**
     * @param trackId the trackId to set
     */
    public final void setTrackId(long trackId)
    {
        this.trackId = trackId;
    }

    /**
     * @return the name
     */
    @Column(name = "Name")
    public final String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the composer
     */
    @Column(name = "Composer")
    public final String getComposer()
    {
        return composer;
    }

    /**
     * @param composer the composer to set
     */
    public final void setComposer(String composer)
    {
        this.composer = composer;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("trackId: ");
        stringBuilder.append(this.getTrackId());
        stringBuilder.append(" | name:");
        stringBuilder.append(this.getName());
        stringBuilder.append(" | composer:");
        stringBuilder.append(this.getComposer());

        return stringBuilder.toString();
    }
}
