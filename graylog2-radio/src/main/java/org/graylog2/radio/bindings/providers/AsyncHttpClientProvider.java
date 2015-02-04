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
package org.graylog2.radio.bindings.providers;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;

import javax.inject.Provider;

/**
 * @author Dennis Oelkers <dennis@torch.sh>
 */
public class AsyncHttpClientProvider implements Provider<AsyncHttpClient> {
    private static AsyncHttpClient asyncHttpClient = null;

    public AsyncHttpClientProvider() {
        if (asyncHttpClient == null) {
            AsyncHttpClientConfig.Builder builder = new AsyncHttpClientConfig.Builder();
            builder.setAllowPoolingConnection(false);
            asyncHttpClient = new AsyncHttpClient(builder.build());
        }
    }

    @Override
    public AsyncHttpClient get() {
        return asyncHttpClient;
    }
}
