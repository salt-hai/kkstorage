package salthai.top.object.storage.amazon.converter.argument;

import salthai.top.object.storage.core.arguments.object.PutObjectArguments;
import salthai.top.object.storage.core.function.Converter;
import salthai.top.object.storage.core.utils.ConverterUtils;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.core.async.BlockingInputStreamAsyncRequestBody;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.transfer.s3.model.UploadRequest;

/**
 * 将上传请求参数转为上传请求
 *
 * @author Kuang HaiBo 2025/5/16 14:57
 */
public class ArgumentsToUploadRequestConverter implements Converter<PutObjectArguments, UploadRequest> {

	/**
	 * Convert the source object of type {@code S} to target type {@code T}.
	 * @param source the source object to convert, which must be an instance of {@code S}
	 * (never {@code null})
	 * @return the converted object, which must be an instance of {@code T} (potentially
	 * {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the desired
	 * target type
	 */
	@Override
	public UploadRequest convert(PutObjectArguments source) {
		// 加载请求
		PutObjectRequest putObjectRequest = ConverterUtils.toTarget(source, new ArgumentsToPutObjectRequestConverter());
		// 请求载体
		BlockingInputStreamAsyncRequestBody body = AsyncRequestBody.forBlockingInputStream(source.getObjectSize());
		body.writeInputStream(source.getInputStream());
		return UploadRequest.builder().requestBody(body).putObjectRequest(putObjectRequest).build();
	}

}
