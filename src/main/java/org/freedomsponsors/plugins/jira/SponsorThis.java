package org.freedomsponsors.plugins.jira;

import com.atlassian.crowd.embedded.api.User;
import com.atlassian.jira.config.properties.APKeys.JiraIndexConfiguration;
import com.atlassian.jira.functest.config.JiraConfig;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.util.http.JiraUrl;

 
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class SponsorThis extends AbstractJiraContextProvider
{       
	
	@Override
    public Map getContextMap(User user, JiraHelper jiraHelper) {
        Map contextMap = new HashMap();        
        //String baseUrl = (String)jiraHelper.getContextParams().get("baseurl");
        Issue currentIssue = (Issue) jiraHelper.getContextParams().get("issue");        
        String issueKey = currentIssue.getKey();        
        contextMap.put("issueKey", issueKey);
        //contextMap.put("baseUrl", baseUrl);
        
        
        return contextMap;
    }
	

}
