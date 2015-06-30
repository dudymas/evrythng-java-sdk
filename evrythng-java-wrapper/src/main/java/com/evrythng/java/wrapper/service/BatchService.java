/*
 * (c) Copyright 2015 EVRYTHNG Ltd London / Zurich
 * www.evrythng.com
 */

package com.evrythng.java.wrapper.service;

import com.evrythng.java.wrapper.ApiManager;
import com.evrythng.java.wrapper.core.EvrythngApiBuilder.Builder;
import com.evrythng.java.wrapper.core.EvrythngServiceBase;
import com.evrythng.java.wrapper.core.http.Status;
import com.evrythng.java.wrapper.exception.EvrythngClientException;
import com.evrythng.thng.resource.model.store.Batch;
import com.evrythng.thng.resource.model.store.TaskOnBatch;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Service wrapper for the {@code /batches} endpoint of the EVRYTHNG API.
 */
public class BatchService extends EvrythngServiceBase {

	public static final String PATH_BATCHES = "/batches";
	public static final String PATH_BATCH = PATH_BATCHES + "/%s";
	public static final String PATH_BATCH_TASKS = PATH_BATCH + "/tasks";
	public static final String PATH_BATCH_TASK = PATH_BATCH_TASKS + "/%s";

	public BatchService(final ApiManager apiManager) {

		super(apiManager);
	}

	/**
	 * Creates a new {@link Batch}.
	 * <p>
	 * POST {@value #PATH_BATCHES}
	 *
	 * @param batch the instance holding the {@link Batch} resource data
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Batch> batchCreator(final Batch batch) throws EvrythngClientException {

		return post(PATH_BATCHES, batch, new TypeReference<Batch>() {

		});
	}

	/**
	 * Retrieves {@link Batch} resources.
	 * <p>
	 * GET {@value #PATH_BATCHES}
	 *
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<Batch>> batchesReader() throws EvrythngClientException {

		return get(PATH_BATCHES, new TypeReference<List<Batch>>() {

		});
	}

	/**
	 * Retrieves the referenced {@link Batch}.
	 * <p>
	 * GET {@value #PATH_BATCH}
	 *
	 * @param batchId batch id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Batch> batchReader(final String batchId) throws EvrythngClientException {

		return get(String.format(PATH_BATCH, batchId), new TypeReference<Batch>() {

		});
	}

	/**
	 * Updates the referenced {@link Batch}.
	 * <p>
	 * PUT {@value #PATH_BATCH}
	 *
	 * @param batchId batch id
	 * @param batch {@link Batch} instance
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Batch> batchUpdater(final String batchId, final Batch batch) throws EvrythngClientException {

		return put(String.format(PATH_BATCH, batchId), batch, new TypeReference<Batch>() {

		});
	}

	/**
	 * Deletes the referenced {@link Batch}.
	 * <p>
	 * DELETE {@value #PATH_BATCH}
	 *
	 * @param batchId batch id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Boolean> batchDeleter(final String batchId) throws EvrythngClientException {

		return delete(String.format(PATH_BATCH, batchId));
	}

	/**
	 * Creates a new {@link TaskOnBatch} to be completed asynchronously on a batch.
	 * <p>
	 * POST {@value #PATH_BATCH_TASKS}
	 *
	 * @param batchId batch id
	 * @param task the instance holding the {@link TaskOnBatch} resource data
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<Void> taskCreator(final String batchId, final TaskOnBatch task) throws EvrythngClientException {

		return post(String.format(PATH_BATCH_TASKS, batchId), task, Status.ACCEPTED, new TypeReference<Void>() {

		});
	}

	/**
	 * Retrieves {@link TaskOnBatch} resources of the batch.
	 * <p>
	 * GET {@value #PATH_BATCH_TASKS}
	 *
	 * @param batchId batch id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<List<TaskOnBatch>> tasksReader(final String batchId) throws EvrythngClientException {

		return get(String.format(PATH_BATCH_TASKS, batchId), new TypeReference<List<TaskOnBatch>>() {

		});
	}

	/**
	 * Retrieves the referenced {@link TaskOnBatch} of the batch.
	 * <p>
	 * GET {@value #PATH_BATCH_TASK}
	 *
	 * @param batchId batch id
	 * @param taskId task id
	 * @return a preconfigured {@link Builder}
	 */
	public Builder<TaskOnBatch> taskReader(final String batchId, final String taskId) throws EvrythngClientException {

		return get(String.format(PATH_BATCH_TASK, batchId, taskId), new TypeReference<TaskOnBatch>() {

		});
	}
}
