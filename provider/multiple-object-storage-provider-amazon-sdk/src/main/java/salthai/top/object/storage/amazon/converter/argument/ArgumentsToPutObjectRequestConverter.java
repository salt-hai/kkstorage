package salthai.top.object.storage.amazon.converter.argument;

import cn.hutool.core.map.MapUtil;
import salthai.top.object.storage.amazon.converter.BaseArgumentsToAwsRequestConverter;
import salthai.top.object.storage.core.arguments.base.PutObjectBaseArguments;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

/**
 * 将对象上传基础参数转为 s3上传对象请求,
 * <p>
 * aws s3
 * 请求{@link PutObjectRequest}与文件载体{@link software.amazon.awssdk.core.async.AsyncRequestBody}
 * {@link software.amazon.awssdk.core.sync.RequestBody}是分开的, 此处处理请求加载基础信息
 * </p>
 *
 * @author Kuang HaiBo 2025/5/16 14:42
 */
public class ArgumentsToPutObjectRequestConverter
		extends BaseArgumentsToAwsRequestConverter<PutObjectBaseArguments, PutObjectRequest> {

	/**
	 * 获取最终生成对象实例
	 * @param putObjectBaseArguments 源对象。传递源对象，方便参数设置
	 * @return 转换后的对象实例
	 */
	@Override
	public PutObjectRequest getInstance(PutObjectBaseArguments putObjectBaseArguments) {
		return PutObjectRequest.builder()
			.bucket(putObjectBaseArguments.getBucketName())
			.key(putObjectBaseArguments.getObjectName())
			.contentType(putObjectBaseArguments.getContentType())
			.contentLength(putObjectBaseArguments.getObjectSize())
			.metadata(putObjectBaseArguments.getMetadata())
			// 请求头部
			.overrideConfiguration(builder -> {
				if (MapUtil.isNotEmpty(putObjectBaseArguments.getRequestHeaders())) {
					putObjectBaseArguments.getRequestHeaders().forEach(builder::putHeader);
				}
			})
			.build();
	}

}
