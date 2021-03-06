/*
 * (c) Copyright Reserved EVRYTHNG Limited 2016. All rights reserved.
 * Use of this material is subject to license.
 * Copying and unauthorised use of this material strictly prohibited.
 */
package com.evrythng.thng.resource.model.store;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Model representation for single <em>redirector rule</em>.
 */
public class RedirectorRule implements Serializable {

	private static final long serialVersionUID = -6245862812999796493L;
	private String match;
	private String name;
	private String redirectUrl;
	private List<ProjectAndApp> delegates;
	private Map<String, String> constants;

	/**
	 * @return Filter expression that will be used during the rule evaluation.
	 */
	public String getMatch() {

		return match;
	}

	/**
	 * @param match Filter expression that will be used during the rule evaluation.
	 */
	public void setMatch(final String match) {

		this.match = match;
	}

	/**
	 * @return Rule name.
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name Rule name.
	 */
	public void setName(final String name) {

		this.name = name;
	}

	/**
	 * @return URL where to redirect.
	 */
	public String getRedirectUrl() {

		return redirectUrl;
	}

	/**
	 * @param redirectUrl URL where to redirect.
	 */
	public void setRedirectUrl(final String redirectUrl) {

		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return List of delegates. Only for account level.
	 */
	public List<ProjectAndApp> getDelegates() {

		return delegates;
	}

	/**
	 * @param delegates List of delegates. Only for account level.
	 */
	public void setDelegates(final List<ProjectAndApp> delegates) {

		this.delegates = delegates;
	}

	/**
	 * @return Key-value pairs of constants to be added into redirection context.
	 */
	public Map<String, String> getConstants() {

		return constants;
	}

	/**
	 * @param constants Key-value pairs of constants to be added into redirection context.
	 */
	public void setConstants(final Map<String, String> constants) {

		this.constants = constants;
	}

	/**
	 * Class holds a pair of project and application ids.
	 */
	public static class ProjectAndApp implements Serializable {

		private static final long serialVersionUID = -1848206315458756297L;
		private String app;
		private String project;

		public ProjectAndApp() {

		}

		public ProjectAndApp(final String project, final String app) {

			this.project = project;
			this.app = app;
		}

		/**
		 * @return application id.
		 */
		public String getApp() {

			return app;
		}

		/**
		 * @param app application id.
		 */
		public void setApp(final String app) {

			this.app = app;
		}

		/**
		 * @return project id.
		 */
		public String getProject() {

			return project;
		}

		/**
		 * @param project project id.
		 */
		public void setProject(final String project) {

			this.project = project;
		}

		@Override
		public boolean equals(final Object o) {

			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			ProjectAndApp that = (ProjectAndApp) o;

			if (app != null ? !app.equals(that.app) : that.app != null) {
				return false;
			}
			return !(project != null ? !project.equals(that.project) : that.project != null);

		}

		@Override
		public int hashCode() {

			int result = app != null ? app.hashCode() : 0;
			result = 31 * result + (project != null ? project.hashCode() : 0);
			return result;
		}

		@Override
		public String toString() {

			return "ProjectAndApp{" +
					"app='" + app + '\'' +
					", project='" + project + '\'' +
					'}';
		}
	}

	@Override
	public boolean equals(final Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		RedirectorRule that = (RedirectorRule) o;

		if (match != null ? !match.equals(that.match) : that.match != null) {
			return false;
		}
		if (name != null ? !name.equals(that.name) : that.name != null) {
			return false;
		}
		if (redirectUrl != null ? !redirectUrl.equals(that.redirectUrl) : that.redirectUrl != null) {
			return false;
		}
		if (delegates != null ? !delegates.equals(that.delegates) : that.delegates != null) {
			return false;
		}
		if (constants != null ? !constants.equals(that.constants) : that.constants != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {

		int result = match != null ? match.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (redirectUrl != null ? redirectUrl.hashCode() : 0);
		result = 31 * result + (delegates != null ? delegates.hashCode() : 0);
		result = 31 * result + (constants != null ? constants.hashCode() : 0);
		return result;
	}
}
