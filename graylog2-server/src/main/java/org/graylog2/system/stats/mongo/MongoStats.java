/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.system.stats.mongo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.net.HostAndPort;

import java.util.List;

@JsonAutoDetect
@AutoValue
public abstract class MongoStats {
    @JsonProperty
    public abstract List<HostAndPort> servers();

    @JsonProperty
    public abstract BuildInfo buildInfo();

    @JsonProperty
    public abstract HostInfo hostInfo();

    @JsonProperty
    public abstract ServerStatus serverStatus();

    @JsonProperty
    public abstract DatabaseStats databaseStats();

    public static MongoStats create(List<HostAndPort> servers,
                                    BuildInfo buildInfo,
                                    HostInfo hostInfo,
                                    ServerStatus serverStatus,
                                    DatabaseStats databaseStats) {
        return new AutoValue_MongoStats(servers, buildInfo, hostInfo, serverStatus, databaseStats);
    }
}
