/*
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.contrib.gmap.api;

import org.apache.wicket.ajax.AjaxRequestTarget;

import wicket.contrib.gmap.js.Array;
import wicket.contrib.gmap.js.Constructor;

/**
 * Represents an Google Maps API's <a
 * href="http://www.google.com/apis/maps/documentation/reference.html#GPolygon">GPolygon</a>.
 */
public class GPolygon extends GOverlay
{
	private static final long serialVersionUID = 1L;

	private final GLatLng[] gLatLngs;
	private final String strokeColor;
	private final int strokeWeight;
	private final float strokeOpacity;
	private final String fillColor;
	private final float fillOpacity;

	public GPolygon(String strokeColor, int strokeWeight, float strokeOpacity, String fillColor,
			float fillOpacity, GLatLng... gLatLngs)
	{
		super();

		this.gLatLngs = gLatLngs;

		this.strokeColor = strokeColor;
		this.strokeWeight = strokeWeight;
		this.strokeOpacity = strokeOpacity;
		this.fillColor = fillColor;
		this.fillOpacity = fillOpacity;
	}

	@Override
	public String getJSconstructor()
	{
		Constructor constructor = new Constructor("GPolygon");

		Array array = new Array();
		for (GLatLng gLatLng : gLatLngs)
		{
			array.add(gLatLng.getJSconstructor());
		}
		constructor.add(array.toJS());

		constructor.addString(strokeColor);
		constructor.addString(strokeWeight);
		constructor.addString(strokeOpacity);
		constructor.addString(fillColor);
		constructor.addString(fillOpacity);

		return constructor.toJS();
	}

	@Override
	protected void updateOnAjaxCall(AjaxRequestTarget target, GEvent overlayEvent)
	{
		// TODO
	}
}
