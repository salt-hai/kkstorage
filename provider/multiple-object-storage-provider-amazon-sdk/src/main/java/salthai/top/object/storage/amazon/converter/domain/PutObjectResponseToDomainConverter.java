package salthai.top.object.storage.amazon.converter.domain;

import salthai.top.object.storage.amazon.converter.S3ResponseToBaseRespondDomainConverter;
import salthai.top.object.storage.core.domain.object.PutObjectDomain;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

/**
 * 上传对象响应转换
 *
 * @author Kuang HaiBo 2025/5/16 16:32
 */
public class PutObjectResponseToDomainConverter
		extends S3ResponseToBaseRespondDomainConverter<PutObjectResponse, PutObjectDomain> {

	/**
	 * 获取最终生成对象实例
	 * @param putObjectResponse 源对象。传递源对象，方便参数设置
	 * @return 转换后的对象实例
	 */
	@Override
	public PutObjectDomain getInstance(PutObjectResponse putObjectResponse) {
		PutObjectDomain putObjectDomain = new PutObjectDomain();
		putObjectDomain.setEtag(putObjectResponse.eTag());
		putObjectDomain.setVersionId(putObjectResponse.versionId());
		return putObjectDomain;
	}

}
