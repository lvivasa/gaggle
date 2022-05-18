package com.gaggle.sdetassesment.utils;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

@Slf4j
public class CloneRemoteRepository {
	public static void cloneRepo() {
		String repoUrl = ConfigureProperties.getProperty("REPO_URL");
		File cloneDirectoryPath = new File("target/repo/workflow_service");

		try {
			log.info("Cloning "+repoUrl+" into "+cloneDirectoryPath);
			Git.cloneRepository()
					.setURI(repoUrl)
					.setDirectory(cloneDirectoryPath)
					.call();
			log.info("Completed Cloning");
		} catch (GitAPIException e) {
			log.info("Exception occurred while cloning repo");
			e.printStackTrace();
		}
	}
}